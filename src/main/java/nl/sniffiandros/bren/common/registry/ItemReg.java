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

    // Machine Gun
    public static final float MACHINE_GUN_RECOIL = 9f;
    public static final float MACHINE_GUN_DAMAGE = MConfig.machineGunDamage.get();
    public static final float N_MACHINE_GUN_DAMAGE = MConfig.netheriteMachineGunDamage.get();

    // Auto-Gun
    public static final float AUTO_GUN_RECOIL = 12f;
    public static final float AUTO_GUN_DAMAGE = MConfig.autoGunDamage.get();
    public static final float N_AUTO_GUN_DAMAGE = MConfig.netheriteAutoGunDamage.get();

    // Rifle
    public static final float RIFLE_RECOIL = 22f;
    public static final float RIFLE_DAMAGE = MConfig.rifleDamage.get();
    public static final float N_RIFLE_DAMAGE = MConfig.netheriteRifleDamage.get();

    // Shotgun
    public static final float SHOTGUN_RECOIL = 25f;
    public static final float SHOTGUN_DAMAGE = MConfig.shotgunDamage.get();
    public static final float N_SHOTGUN_DAMAGE = MConfig.netheriteShotgunDamage.get();

    public static final float DB_SHOTGUN_RECOIL = 27f;
    public static final float DB_SHOTGUN_DAMAGE = MConfig.dbshotgunDamage.get();
    public static final float NETHERITE_DB_SHOTGUN_DAMAGE = MConfig.netheritedbshotgunDamage.get();


    // Revolver
    public static final float REVOLVER_RECOIL = 15f;
    public static final float REVOLVER_DAMAGE = MConfig.revolverDamage.get();
    public static final float N_REVOLVER_DAMAGE = MConfig.netheriteRevolverDamage.get();

    // pistol!!
    public static final float PISTOL_RECOIL = 12f;
    public static final float PISTOL_DAMAGE = MConfig.pistolDamage.get();
    public static final float NETHERITE_PISTOL_DAMAGE = MConfig.netheritepistolDamage.get();
    // now netherite!!

    public static final float SMG_RECOIL = 4;
    public static final float SMG_DAMAGE = MConfig.smgDamage.get();
    public static final float NETHERITE_SMG_DAMAGE = MConfig.netheritesmgDamage.get();

    public static final float HEAVY_MG_RECOIL = 7;
    public static final float HEAVY_MG_DAMAGE = MConfig.heavyMGDamage.get();
    public static final float NETHERITE_HEAVY_MG_DAMAGE = MConfig.netheriteheavyMGDamage.get();

    public static final float AUTO_SHOTGUN_RECOIL = 18;
    public static final float AUTO_SHOTGUN_DAMAGE = MConfig.autoshotgunDamage.get();
    public static final float NETHERITE_AUTO_SHOTGUN_DAMAGE = MConfig.netheriteautoshotgunDamage.get();

    public static final float HEAVY_RIFLE_RECOIL = 35;
    public static final float HEAVY_RIFLE_DAMAGE = MConfig.heavyrifleDamage.get();
    public static final float NETHERITE_HEAVY_RIFLE_DAMAGE = MConfig.netheriteheavyrifleDamage.get();

    public static final Item MACHINE_GUN = registerItem("machine_gun", new MachineGunItem(
            new FabricItemSettings(), ToolMaterials.IRON, TagReg.MEDIUM_MAGAZINES, new GunProperties().rangedDamage(MACHINE_GUN_DAMAGE).fireRate(3).recoil(MACHINE_GUN_RECOIL)
            .shootSound(SoundReg.ITEM_MACHINE_GUN_SHOOT, SoundReg.ITEM_MACHINE_GUN_SHOOT_SILENCED)));

    public static final Item HEAVY_MG = registerItem("heavy_mg", new HeavyMGItem(
            new FabricItemSettings(), ToolMaterials.IRON, TagReg.HEAVY_MAGAZINES, new GunProperties().rangedDamage(HEAVY_MG_DAMAGE).fireRate(4).recoil(HEAVY_MG_RECOIL)
            .shootSound(SoundReg.ITEM_HEAVY_MG_SHOOT, SoundReg.ITEM_HEAVY_MG_SHOOT_SILENCED)));

    public static final Item NETHERITE_HEAVY_MG = registerItem("netherite_heavy_mg", new HeavyMGItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, TagReg.HEAVY_MAGAZINES, new GunProperties().rangedDamage(NETHERITE_HEAVY_MG_DAMAGE).fireRate(4).recoil(HEAVY_MG_RECOIL)
            .shootSound(SoundReg.ITEM_HEAVY_MG_SHOOT, null)));

    public static final Item NETHERITE_MACHINE_GUN = registerItem("netherite_machine_gun", new MachineGunItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, TagReg.MEDIUM_MAGAZINES, new GunProperties().rangedDamage(N_MACHINE_GUN_DAMAGE).fireRate(3).recoil(MACHINE_GUN_RECOIL)
            .shootSound(SoundReg.ITEM_MACHINE_GUN_SHOOT, SoundReg.ITEM_MACHINE_GUN_SHOOT_SILENCED)));

    public static final Item AUTO_GUN = registerItem("auto_gun", new GunWithMagItem(
            new FabricItemSettings(), ToolMaterials.IRON, TagReg.MEDIUM_MAGAZINES, new GunProperties().rangedDamage(AUTO_GUN_DAMAGE).fireRate(5).recoil(AUTO_GUN_RECOIL)
            .shootSound(SoundReg.ITEM_AUTO_GUN_SHOOT, SoundReg.ITEM_AUTO_GUN_SHOOT_SILENCED)));

    public static final Item NETHERITE_AUTO_GUN = registerItem("netherite_auto_gun", new GunWithMagItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, TagReg.MEDIUM_MAGAZINES, new GunProperties().rangedDamage(N_AUTO_GUN_DAMAGE).fireRate(4).recoil(AUTO_GUN_RECOIL)
            .shootSound(SoundReg.ITEM_AUTO_GUN_SHOOT, SoundReg.ITEM_AUTO_GUN_SHOOT_SILENCED)));

    public static final Item RIFLE = registerItem("rifle", new GunWithMagItem(
            new FabricItemSettings(), ToolMaterials.IRON, TagReg.SHORT_MAGAZINES, new GunProperties().rangedDamage(RIFLE_DAMAGE).fireRate(20).recoil(RIFLE_RECOIL)
            .shootSound(SoundReg.ITEM_RIFLE_SHOOT, SoundReg.ITEM_RIFLE_SHOOT_SILENCED)));

    public static final Item HEAVY_RIFLE = registerItem("heavy_rifle", new HeavyRifleItem(
            new FabricItemSettings(), ToolMaterials.IRON, new GunProperties().rangedDamage(HEAVY_RIFLE_DAMAGE).fireRate(20).recoil(HEAVY_RIFLE_RECOIL)
            .shootSound(SoundReg.ITEM_HEAVY_RIFLE_SHOOT, null)));

    public static final Item NETHERITE_HEAVY_RIFLE = registerItem("netherite_heavy_rifle", new HeavyRifleItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, new GunProperties().rangedDamage(NETHERITE_HEAVY_RIFLE_DAMAGE).fireRate(20).recoil(HEAVY_RIFLE_RECOIL)
            .shootSound(SoundReg.ITEM_HEAVY_RIFLE_SHOOT, null)));

    public static final Item NETHERITE_RIFLE = registerItem("netherite_rifle", new GunWithMagItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, TagReg.SHORT_MAGAZINES, new GunProperties().rangedDamage(N_RIFLE_DAMAGE).fireRate(20).recoil(RIFLE_RECOIL)
            .shootSound(SoundReg.ITEM_RIFLE_SHOOT, SoundReg.ITEM_RIFLE_SHOOT_SILENCED)));

    public static final Item SHOTGUN = registerItem("shotgun", new ShotgunItem(
            new FabricItemSettings(), ToolMaterials.IRON, new GunProperties().rangedDamage(SHOTGUN_DAMAGE).fireRate(20).recoil(SHOTGUN_RECOIL).bulletSpeed(1.8F)
            .shootSound(SoundReg.ITEM_SHOTGUN_SHOOT, null)));

    public static final Item NETHERITE_SHOTGUN = registerItem("netherite_shotgun", new ShotgunItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, new GunProperties().rangedDamage(N_SHOTGUN_DAMAGE).fireRate(20).recoil(SHOTGUN_RECOIL).bulletSpeed(1.5F)
            .shootSound(SoundReg.ITEM_SHOTGUN_SHOOT, null)));

    public static final Item PISTOL = registerItem("pistol", new PistolItem(
            new FabricItemSettings() , ToolMaterials.IRON, TagReg.LIGHT_MAGAZINES, new GunProperties().rangedDamage(PISTOL_DAMAGE).fireRate(6).recoil(PISTOL_RECOIL)
            .shootSound(SoundReg.ITEM_PISTOL_SHOOT, SoundReg.ITEM_PISTOL_SHOOT_SILENCED)));

    public static final Item NETHERITE_PISTOL = registerItem("netherite_pistol", new PistolItem(
            new FabricItemSettings().fireproof() , ToolMaterials.NETHERITE, TagReg.LIGHT_MAGAZINES, new GunProperties().rangedDamage(NETHERITE_PISTOL_DAMAGE).fireRate(6).recoil(PISTOL_RECOIL)
            .shootSound(SoundReg.ITEM_PISTOL_SHOOT, null)));

    public static final Item SMG = registerItem("smg", new GunWithMagItem(
            new FabricItemSettings() , ToolMaterials.IRON, TagReg.LIGHT_MAGAZINES, new GunProperties().rangedDamage(SMG_DAMAGE).fireRate(2).recoil(SMG_RECOIL)
            .shootSound(SoundReg.ITEM_SMG_SHOOT, SoundReg.ITEM_SMG_SHOOT_SILENCED)));

    public static final Item NETHERITE_SMG = registerItem("netherite_smg", new GunWithMagItem(
            new FabricItemSettings().fireproof() , ToolMaterials.NETHERITE, TagReg.LIGHT_MAGAZINES, new GunProperties().rangedDamage(NETHERITE_SMG_DAMAGE).fireRate(2).recoil(SMG_RECOIL)
            .shootSound(SoundReg.ITEM_SMG_SHOOT, SoundReg.ITEM_SMG_SHOOT_SILENCED)));

    public static final Item DB_SHOTGUN = registerItem("db_shotgun", new DBShotgunItem(
            new FabricItemSettings(), ToolMaterials.IRON, new GunProperties().rangedDamage(DB_SHOTGUN_DAMAGE).fireRate(15).recoil(DB_SHOTGUN_RECOIL).bulletSpeed(1.8F)
            .shootSound(SoundReg.ITEM_DB_SHOTGUN_SHOOT, null)));

    public static final Item NETHERITE_DB_SHOTGUN = registerItem("netherite_db_shotgun", new DBShotgunItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, new GunProperties().rangedDamage(NETHERITE_DB_SHOTGUN_DAMAGE).fireRate(15).recoil(DB_SHOTGUN_RECOIL).bulletSpeed(1.8F)
            .shootSound(SoundReg.ITEM_DB_SHOTGUN_SHOOT, null)));

    public static final Item AUTO_SHOTGUN = registerItem("auto_shotgun", new AutoShotgunItem(
            new FabricItemSettings(), ToolMaterials.IRON, new GunProperties().rangedDamage(AUTO_SHOTGUN_DAMAGE).fireRate(10).recoil(AUTO_SHOTGUN_RECOIL).bulletSpeed(1.8F)
            .shootSound(SoundReg.ITEM_DB_SHOTGUN_SHOOT, null)));

    public static final Item NETHERITE_AUTO_SHOTGUN = registerItem("netherite_auto_shotgun", new AutoShotgunItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, new GunProperties().rangedDamage(NETHERITE_AUTO_SHOTGUN_DAMAGE).fireRate(10).recoil(AUTO_SHOTGUN_RECOIL).bulletSpeed(1.8F)
            .shootSound(SoundReg.ITEM_DB_SHOTGUN_SHOOT, null)));

    public static final Item REVOLVER = registerItem("revolver", new RevolverItem(
            new FabricItemSettings(), ToolMaterials.IRON, new GunProperties().rangedDamage(REVOLVER_DAMAGE).fireRate(15).recoil(REVOLVER_RECOIL)
            .shootSound(SoundReg.ITEM_REVOLVER_SHOOT, null)));

    public static final Item NETHERITE_REVOLVER = registerItem("netherite_revolver", new RevolverItem(
            new FabricItemSettings().fireproof(), ToolMaterials.NETHERITE, new GunProperties().rangedDamage(N_REVOLVER_DAMAGE).fireRate(15).recoil(REVOLVER_RECOIL)
            .shootSound(SoundReg.ITEM_REVOLVER_SHOOT, null)));



    public static final Item MAGAZINE = registerItem("magazine", new MagazineItem(new FabricItemSettings(), 20));
    public static final Item CLOTHED_MAGAZINE = registerItem("clothed_magazine", new ColorableMagazineItem(new FabricItemSettings(), 20));

    public static final Item HEAVY_MAGAZINE = registerItem("heavy_magazine", new MagazineItem(new FabricItemSettings(), 35));
    public static final Item SHORT_MAGAZINE = registerItem("short_magazine", new MagazineItem(new FabricItemSettings(), 6));
    public static final Item LIGHT_MAGAZINE = registerItem("light_magazine", new MagazineItem(new FabricItemSettings(), 13));
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
