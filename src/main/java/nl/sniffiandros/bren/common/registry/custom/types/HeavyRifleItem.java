package nl.sniffiandros.bren.common.registry.custom.types;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import nl.sniffiandros.bren.common.registry.EnchantmentReg;
import nl.sniffiandros.bren.common.registry.ItemReg;
import nl.sniffiandros.bren.common.registry.SoundReg;

public class HeavyRifleItem extends BulletOnlyGun {
    public HeavyRifleItem(Settings settings, ToolMaterial material, GunProperties gunProperties) {
        super(settings, material, gunProperties);
    }



    @Override
    protected void onInsert(ItemStack stack, PlayerEntity player) {
        player.getWorld().playSound(null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundReg.ITEM_HEAVY_RIFLE_INSERT,
                SoundCategory.PLAYERS, 2.5F, 1.0F - (player.getRandom().nextFloat() - 0.5F) / 4);
    }

    @Override
    protected void onFullyLoaded(ItemStack stack, PlayerEntity player) {
        player.getWorld().playSound(null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundReg.ITEM_HEAVY_RIFLE_RACK,
                SoundCategory.PLAYERS, 2.5F, 1.0F - (player.getRandom().nextFloat() - 0.5F) / 4);
    }

    @Override
    public int getMaxCapacity(ItemStack stack) {
        return Math.round(Math.max(1, EnchantmentHelper.getLevel(EnchantmentReg.OVERFLOW, stack)/2));
    }

    @Override
    public float spread() {
        return 1.1F;
    }

    @Override
    public int bulletAmount() {
        return 6;
    }

    // what the heck decides the bullet that is in the hud overlayyy
    @Override
    public Item compatibleBullet() {return ItemReg.SHELL;}



    @Override
    public int reloadSpeed() {
        return 35;
    }

}
