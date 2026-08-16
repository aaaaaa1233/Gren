package nl.sniffiandros.bren.common.registry.custom.types;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;

public class MachineGunItem extends GunWithMagItem {
    public MachineGunItem(Settings settings, ToolMaterial material, TagKey<Item> compatibleMagazines, GunProperties gunProperties) {
        super(settings, material, compatibleMagazines, gunProperties);
    }

}
