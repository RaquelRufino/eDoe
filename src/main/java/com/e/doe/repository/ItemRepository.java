package com.e.doe.repository;

import com.e.doe.models.Item;

public interface ItemRepository {

	Item findById(long id);
}
