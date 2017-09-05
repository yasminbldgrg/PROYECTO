package com.auto.control;

import java.util.ArrayList;

public interface Control<Entity> { // una entidad puede ser cliente detalle de venta puede ser cualquiera 
    // <> en una estructura generica y funciona en cualquier tipo de clase
	
public ArrayList<Entity> list() throws Throwable;
public void insert(Entity entity) throws Throwable;
public void search(Entity entity) throws Throwable;
public void update(Entity entity) throws Throwable;
}
