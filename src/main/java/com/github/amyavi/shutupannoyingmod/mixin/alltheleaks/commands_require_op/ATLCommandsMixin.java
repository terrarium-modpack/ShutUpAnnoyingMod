package com.github.amyavi.shutupannoyingmod.mixin.alltheleaks.commands_require_op;

import com.github.amyavi.shutupannoyingmod.annotation.RequiresMod;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.uncandango.alltheleaks.commands.ATLCommands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@RequiresMod("alltheleaks")
@Mixin(value = ATLCommands.class, remap = false)
public abstract class ATLCommandsMixin {
    @ModifyExpressionValue(method = { "registerClientCommands", "registerServerCommands" },
            at = @At(value = "INVOKE", target = "Lnet/minecraft/commands/Commands;literal" +
                    "(Ljava/lang/String;)Lcom/mojang/brigadier/builder/LiteralArgumentBuilder;",
                    ordinal = 0))
    private static LiteralArgumentBuilder<CommandSourceStack> registerCommands$literal(
            final LiteralArgumentBuilder<CommandSourceStack> original
    ) {
        return original.requires(ctx -> ctx.hasPermission(Commands.LEVEL_ADMINS));
    }
}
