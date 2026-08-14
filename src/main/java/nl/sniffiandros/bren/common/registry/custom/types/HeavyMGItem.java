package nl.sniffiandros.bren.common.registry.custom.types;

import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import nl.sniffiandros.bren.common.Bren;
import nl.sniffiandros.bren.common.entity.IGunUser;
import nl.sniffiandros.bren.common.registry.SoundReg;
import nl.sniffiandros.bren.common.utils.GunHelper;

public class HeavyMGItem extends GunWithMagItem {
    public HeavyMGItem(Settings settings, ToolMaterial material, TagKey<Item> compatibleMagazines, GunProperties gunProperties) {
        super(settings, material, compatibleMagazines, gunProperties);
    }



    @Override
    public int reloadSpeed() {
        return 40;
    }


    // i did thiz becacse the reloadtick funciton is jank and only works on guns with the same 20 tick reload speed
    // divide the floating point thingy by how much your reloadspeed has multiplied for it to work rightt
    @Override
    public void reloadTick(ItemStack stack, World world, PlayerEntity player, IGunUser gunUser) {

        ItemCooldownManager cooldownManager = player.getItemCooldownManager();

        if (!cooldownManager.isCoolingDown(stack.getItem())) {
            if (GunWithMagItem.hasMagazine(stack)) {

                GunWithMagItem.unloadMagazine(stack, player);

                world.playSound(null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        SoundReg.ITEM_MAGAZINE_REMOVE,
                        SoundCategory.PLAYERS, 1.0F, 1.0F - (player.getRandom().nextFloat() - 0.5F) / 4);

            } else {
                ItemStack mag = Bren.getMagazineFromPlayer(player, ((GunWithMagItem) stack.getItem()).compatibleMagazines());
                GunWithMagItem.putMagazine(stack, mag);
                mag.decrement(1);
            }
            gunUser.setGunState(GunHelper.GunStates.NORMAL);
            gunUser.setCanReload(true);
        } else if (cooldownManager.getCooldownProgress(stack.getItem(),1) == 0.325F && !GunWithMagItem.hasMagazine(stack)) {
            world.playSound(null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundReg.ITEM_MAGAZINE_INSERT,
                    SoundCategory.PLAYERS, 1.0F, 1.0F - (player.getRandom().nextFloat() - 0.5F) / 4);
        }

    }

}
