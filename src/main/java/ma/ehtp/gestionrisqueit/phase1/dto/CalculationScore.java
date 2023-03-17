package ma.ehtp.gestionrisqueit.phase1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CalculationScore {

    private Integer number0;
    private Integer number1;
    private Integer number2;
    private Double percentage0;
    private Double percentage1;
    private Double percentage2;
    private Integer  overallScore;
    private Integer  maximumPossibleScore;
    private Integer maturityLevel;


}
