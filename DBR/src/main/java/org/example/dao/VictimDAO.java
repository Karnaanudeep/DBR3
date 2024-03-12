package org.example.dao;

import org.example.entity.VictimPojo;

import java.util.List;
import java.util.Optional;

public interface VictimDAO {
    List<VictimPojo> fetchAllVictims();
    List<VictimPojo> fetchAVictim(int victimAge);
    List<VictimPojo> fetchByVaccinatedStatus(boolean isVaccinated);
    void removeVictim(int victimAge);
    VictimPojo addVictim(VictimPojo newVictim);
    VictimPojo updateVictim(VictimPojo updateVictim);

}
