package icbm.classic.computercraft;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface ICCServersPeripheral extends IPeripheral {
    @Nonnull
    @Override
    String getType();

    @Nonnull
    @Override
    String[] getMethodNames();

    @Nullable
    @Override
    Object[] callMethod(@Nonnull IComputerAccess iComputerAccess, @Nonnull ILuaContext iLuaContext, int i, @Nonnull Object[] objects) throws LuaException, InterruptedException;

    @Override
    default void attach(@Nonnull IComputerAccess computer) {

    }

    @Override
    default void detach(@Nonnull IComputerAccess computer) {

    }

    class Provider implements IPeripheralProvider {
        @Nullable
        @Override
        public IPeripheral getPeripheral(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
            TileEntity tile = world.getTileEntity(pos);
            return tile instanceof ICCServersPeripheral ? (ICCServersPeripheral) tile : null;
        }
    }

}
