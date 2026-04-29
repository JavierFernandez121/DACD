package ulpgc.dacd.gasstations.repository;

import ulpgc.dacd.gasstations.model.GasStation;

import java.util.List;

public interface GasStationRepository {
    void saveAll(List<GasStation> stations);
}