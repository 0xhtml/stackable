package me._0xhtml.stackable;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Shadow
    private int count;

    @WrapMethod(method = "getMaxCount")
    int getMaxCount(@NotNull Operation<Integer> original) {
        return Math.max(this.count, original.call());
    }
}
