package nl.sniffiandros.bren.common.registry.custom.types;

import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.RotationAxis;
import nl.sniffiandros.bren.common.registry.EnchantmentReg;
import nl.sniffiandros.bren.common.registry.ItemReg;
import nl.sniffiandros.bren.common.registry.SoundReg;
import nl.sniffiandros.bren.common.utils.GunHelper;

public class AutoShotgunItem extends BulletOnlyGun {

    public AutoShotgunItem(Settings settings, ToolMaterial material, GunProperties gunProperties) {
        super(settings, material, gunProperties);
    }

    @Override
    protected void onInsert(ItemStack stack, PlayerEntity player) {
        player.getWorld().playSound(null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundReg.ITEM_SHOTGUN_SHELL_INSERT,
                SoundCategory.PLAYERS, 1.0F, 1.0F - (player.getRandom().nextFloat() - 0.5F) / 4);
    }



    @Override
    public int getMaxCapacity(ItemStack stack) {
        return 5 * Math.round(Math.max(1, EnchantmentHelper.getLevel(EnchantmentReg.OVERFLOW, stack)/2));
    }


    @Override
    public int bulletLifespan() {
        return 9;
    }

    @Override
    public float spread() {
        return 4.0F;
    }

    @Override
    public int bulletAmount() {
        return 4;
    }

    @Override
    public Item compatibleBullet() {return ItemReg.SHELL;}

    @Override
    public int reloadSpeed() {
        return 14;
    }
}
