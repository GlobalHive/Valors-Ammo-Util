package com.valor.valors_ammo_util.component;

import com.hypixel.hytale.component.Component;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.valor.valors_ammo_util.interaction.AmmoInfo;

import java.util.ArrayList;
import java.util.Arrays;

public class LoadedAmmoComponent implements Component<EntityStore> {
    private final ArrayList<String> itemIds;
    private final ArrayList<Integer> itemQuantities;
    private final String ammoInfoVar;
    private final boolean useItemModel;

    public LoadedAmmoComponent() {
        this(new String[0], new int[0], AmmoInfo.AMMO_INFO_VAR_ID, true);
    }

    public LoadedAmmoComponent(String[] ids, int[] quantities) {
        this(ids, quantities, AmmoInfo.AMMO_INFO_VAR_ID, true);
    }

    public LoadedAmmoComponent(String[] ids, int[] quantities, String ammoInfoVar, boolean useItemModel) {
        this.itemIds = new ArrayList<>();
        this.itemQuantities = new ArrayList<>();
        this.ammoInfoVar = ammoInfoVar == null || ammoInfoVar.isBlank() ? AmmoInfo.AMMO_INFO_VAR_ID : ammoInfoVar;
        this.useItemModel = useItemModel;

        if (ids == null || quantities == null || ids.length != quantities.length) {
            return;
        }

        this.itemIds.addAll(Arrays.asList(ids));
        for (int quantity : quantities) {
            this.itemQuantities.add(quantity);
        }
    }

    public String[] getItemIds() {
        return this.itemIds.toArray(new String[0]);
    }

    public int[] getItemQuantities() {
        return this.itemQuantities.stream().mapToInt(Integer::intValue).toArray();
    }

    public String getAmmoInfoVar() {
        return this.ammoInfoVar;
    }

    public boolean getUseItemModel() {
        return this.useItemModel;
    }

    @Override
    public Component<EntityStore> clone() {
        return new LoadedAmmoComponent(this.getItemIds(), this.getItemQuantities(), this.ammoInfoVar, this.useItemModel);
    }
}