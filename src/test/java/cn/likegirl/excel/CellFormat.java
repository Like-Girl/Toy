package cn.likegirl.excel;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CellFormat {

  private String value;

  private Boolean m;

  private Integer fc;

  private Integer lc;

  private Integer fr;

  private Integer lr;

  private Integer mc;

  private Integer mr;

}
