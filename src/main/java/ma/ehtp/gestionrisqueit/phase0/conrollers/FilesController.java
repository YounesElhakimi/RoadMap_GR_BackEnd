package ma.ehtp.gestionrisqueit.phase0.conrollers;

import java.util.*;
import java.util.stream.Collectors;

import ma.ehtp.gestionrisqueit.phase0.messages.ResponseMessage;
import ma.ehtp.gestionrisqueit.phase0.modelles.FileInfo;
import ma.ehtp.gestionrisqueit.phase0.services.FilesStorageService;
import ma.ehtp.gestionrisqueit.phase0.tools.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpSession;

@RestController
public class FilesController  extends InitOrg{
    @Autowired
    FilesStorageService storageService;



     @PostMapping("/deleteFile")
     public ResponseEntity<ResponseMessage> deleteFile(@RequestBody FileInfo fileInfo){

         String message = "";

         try {
             message = "delete successfully: ";
                storageService.delet(fileInfo.getName());
             U.ptxt("ok ..............................");
             return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
         } catch (Exception e) {
             message = "Fail to delete!";
             U.ptxt("error .............................. "+e.getMessage());
             return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
         }
     }


    @PostMapping(value={"/upload" , "uploads/upload"})
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files , HttpSession session) {
        String message = "";
        initOrg(session);
        String sousFolder = ""+organization.getId();
        U.ptxt("sousFolder :"+sousFolder);
        storageService.setSousFolder(sousFolder);
        try {
            List<String> fileNames = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file -> {
                try {
                    storageService.save(file);
                }catch (Exception e){
                    U.ptxt("Exception storageService.save e : "+e.getMessage());
                }

                fileNames.add(file.getOriginalFilename());
            });
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @GetMapping("/Allfiles")
    public ResponseEntity getAllListFiles(  HttpSession session) {
        initOrg(session);
        try{
            String sousFolder = "" + organization.getId();

            storageService.setSousFolder(sousFolder);

        }catch (Exception e){

            U.ptxt("ppst Allfiles setSousFolder e : "+e.getMessage());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("error in setFolser"));

        }

        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }


}