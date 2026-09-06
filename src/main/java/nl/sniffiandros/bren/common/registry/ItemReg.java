package nl.sniffiandros.bren.common.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import nl.sniffiandros.bren.common.Bren;
import nl.sniffiandros.bren.common.config.MConfig;
import nl.sniffiandros.bren.common.registry.custom.*;
import nl.sniffiandros.bren.common.registry.custom.types.*;
import nl.sniffiandros.bren.common.registry.custom.ColorableMagazineItem;
import nl.sniffiandros.bren.common.registry.custom.MagazineItem;
import nl.sniffiandros.bren.common.registry.custom.types.*;

public class ItemReg {

    // Rifle
    public static final float RIFLE_RECOIL = 30f;
    public static final float RIFLE_DAMAGE = MConfig.rifleDamage.get();


    // Shotgun
    public static final float SHOTGUN_RECOIL = 25f;
    public static final float SHOTGUN_DAMAGE = MConfig.shotgunDamage.get();




    public static final Item RIFLE = registerItem("rifle", new RifleItem(
            new FabricItemSettings(), ToolMaterials.IRON,  new GunProperties().rangedDamage(RIFLE_DAMAGE).fireRate(30).recoil(RIFLE_RECOIL)
            .shootSound(SoundReg.ITEM_RIFLE_SHOOT, SoundReg.ITEM_RIFLE_SHOOT_SILENCED)));



    public static final Item SHOTGUN = registerItem("shotgun", new ShotgunItem(
            new FabricItemSettings(), ToolMaterials.IRON, new GunProperties().rangedDamage(SHOTGUN_DAMAGE).fireRate(20).recoil(SHOTGUN_RECOIL).bulletSpeed(1.8F)
            .shootSound(SoundReg.ITEM_SHOTGUN_SHOOT, null)));




    //public static final Item MAGAZINE = registerItem("magazine", new MagazineItem(new FabricItemSettings(), 20));
   // public static final Item CLOTHED_MAGAZINE = registerItem("clothed_magazine", new ColorableMagazineItem(new FabricItemSettings(), 20));

   // public static final Item HEAVY_MAGAZINE = registerItem("heavy_magazine", new MagazineItem(new FabricItemSettings(), 35));
    //public static final Item SHORT_MAGAZINE = registerItem("short_magazine", new MagazineItem(new FabricItemSettings(), 6));
  //  public static final Item LIGHT_MAGAZINE = registerItem("light_magazine", new MagazineItem(new FabricItemSettings(), 13));
    public static final Item BULLET = registerItem("bullet", new Item(new FabricItemSettings()));
    public static final Item SHELL = registerItem("shell", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_BULLET = registerItem("diamond_bullet", new Item(new FabricItemSettings()));
    public static final Item AUTO_LOADER_CONTRAPTION = registerItem("auto_loader_contraption", new Item(new FabricItemSettings()));
    public static final Item METAL_TUBE = registerItem("metal_tube", new Item(new FabricItemSettings()));

    public static final Item WORKBENCH = registerItem("workbench", new BlockItem(BlockReg.WORKBENCH, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Bren.MODID, name), item);
    }

    public static void reg(){}
}
