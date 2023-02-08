package sky.pro.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public enum Measure {
    GRAMM("г."),
    SHTUK("шт."),
    ST_LOJKI("ст.л."),
    PO_VKUSU("по вкусу"),
    ZUBEC("зуб."),
    MILILITR("мл."),
    GOLOVKA("головка"),
    PUCHOK("пучок"),
    CH_LOJKI("чайные ложки");
    private final String measure;


}
