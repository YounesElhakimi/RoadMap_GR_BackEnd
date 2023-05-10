package ma.ehtp.gestionrisqueit.phase1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CalculationScore {

    private Integer number0;
    private Integer number1;
    private Integer number2;
    private Integer number3;
    private Integer number4;
    private Integer number5;
    private Double percentage0;
    private Double percentage1;
    private Double percentage2;
    private Double percentage3;
    private Double percentage4;
    private Double percentage5;
    private Double  overallScore;
    private Integer  maximumPossibleScore;
    private Integer maturityLevel;


}
