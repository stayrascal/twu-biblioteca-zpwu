package com.twu.biblioteca.repository;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.stock.Stock;

import java.util.List;

public interface Repository<T> {

    void displayResourceListInfo(Console console);

    List<Stock<T>> getAvailableResourceStockList();

    List<Stock<T>> getResourceStockList();

    String getResourceNameById(Integer key);
}
