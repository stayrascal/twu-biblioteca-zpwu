package com.twu.biblioteca.resource;

import com.twu.biblioteca.Console;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class ResourceList<T> {

    private final Set<T> resources = new TreeSet<>();

    public ResourceList(List<T> resources) {
        this.resources.addAll(resources);
    }

    public Set<T> getResources() {
        return resources;
    }

    public abstract void displayResourceListInfo(Console console);

    public abstract String getResourceNameById(Integer id);
}
