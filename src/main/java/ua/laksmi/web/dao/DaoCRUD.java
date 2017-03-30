package ua.laksmi.web.dao;

import ua.laksmi.web.domain.tables.Farm;
import ua.laksmi.web.domain.tables.Production;

import java.util.List;

/**
 * Created by Dobriks on 16.03.2017.
 */
public interface DaoCRUD {
    List<Production> getListProduction(int idFarm);
    List<Farm> getListFarm();
    boolean deleteProduction(int idProduction);
    boolean deleteFarm(int idFarm);
    Production editProduction(Production production);
    Production addProduction(Production production);
    Farm editFarm(Farm farm);
    Farm addFarm(Farm farm);
}
