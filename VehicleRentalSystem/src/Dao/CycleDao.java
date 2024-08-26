package Dao;

import java.util.List;

import Model.Cycle;

public interface CycleDao {

	void addCycleModel(Cycle cycle);
	Cycle getCycleModelByLicenseNumber(String name);
	int getCycleCount();
	List<Cycle> getAllCycles();

}
