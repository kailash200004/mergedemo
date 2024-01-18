package com.jci.dao;

import java.util.List;

import com.jci.model.RulingMarket;
public interface RulingMarketDao {
	public void create(RulingMarket RulingMarket);
	public void update(RulingMarket RulingMarket);
	public RulingMarket edit(int id);
	public void delete(int id);
	public RulingMarket find(int id);
	public List <RulingMarket> getAll();
	public boolean submitform(RulingMarket RulingMarket);
}
