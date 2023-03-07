package com.example.msaservicecoffeestatus.domain.repository;



import com.example.msaservicecoffeestatus.domain.entity.StatusEntity;

import java.util.List;

public interface IStatusRepository {
	long getAllStatusCount();
	List<StatusEntity> getAllStatus(String page, String size, String sort, String sortKey);
	StatusEntity addStatus(StatusEntity statusEntity);
	StatusEntity modifyStatus(StatusEntity statusEntity);
	void removeStatus(List<StatusEntity> statusEntity);
}
