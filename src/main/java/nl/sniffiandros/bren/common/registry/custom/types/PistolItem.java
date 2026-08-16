package nl.sniffiandros.bren.common.registry.custom.types;

import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.RotationAxis;
import nl.sniffiandros.bren.common.entity.IGunUser;
import nl.sniffiandros.bren.common.registry.custom.PoseType;
import nl.sniffiandros.bren.common.utils.GunHelper;

public class PistolItem extends GunWithMagItem {

    public PistolItem(Settings settings, ToolMaterial material, TagKey<Item> compatibleMagazines, GunProperties gunProperties) {
        super(settings, material, compatibleMagazines, gunProperties);
    }

    @Override
    public PoseType holdingPose() {
        return PoseType.ONE_ARM;
    }



    @Override
    public boolean applyCustomMatrix(LivingEntity entity, GunHelper.GunStates state, MatrixStack matrices, ItemStack stack, float cooldownProgress, ModelTransformationMode renderMode, boolean leftHanded) {
        if (entity instanceof IGunUser gunUser && cooldownProgress > 0) {

            boolean reloading = gunUser.getGunState().equals(GunHelper.GunStates.RELOADING);

            float sin = (float) Math.sin((cooldownProgress * 2 - 0.5) * Math.PI) * 0.5F + 0.5F;

            if (renderMode.isFirstPerson()) {
                matrices.translate(0, 0, 0);
            }


            // how the heck was this animated with only numbers??
            // i dont know how to make whatever variables to decide the sines so im spamming if statemnts


            matrices.multiply(RotationAxis.NEGATIVE_Z.rotation((reloading ? sin / -3 : 0)));
            matrices.translate(0, (reloading ? sin / 5 : -0.15), 0);

            matrices.multiply(RotationAxis.NEGATIVE_X.rotation(cooldownProgress * 3));
            if (cooldownProgress >= cooldownProgress/2) {
                matrices.multiply(RotationAxis.POSITIVE_Z.rotation((reloading ? sin / 3 : 0)));
                matrices.translate(0, (reloading ? sin / 7 : 0.0), 0);
                matrices.multiply(RotationAxis.POSITIVE_X.rotation(cooldownProgress * 6));
            }

        }

        return true;
    }





    @Override
    public boolean renderOnBack() {
        return false;
    }

    @Override
    public boolean hasGUIModel() {
        return false;
    }


}
