package icbm.classic.computercraft;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.ILuaObject;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;

import javax.annotation.Nonnull;

/**
 * All credit belongs to:
 * https://github.com/rolandoislas/PeripheralsPlusOne/blob/master/src/main/java/com/austinv11/peripheralsplusplus/lua/LuaObjectPeripheralWrap.java
 */

public class LuaObjectPeripheralWrap implements ILuaObject {

    private IPeripheral peripheral;
    private IComputerAccess computer;

    public LuaObjectPeripheralWrap(IPeripheral peripheral, IComputerAccess computer) {
        this.peripheral = peripheral;
        this.computer = computer;
    }

    @Nonnull
    @Override
    public String[] getMethodNames() {
        return peripheral.getMethodNames();
    }

    @Override
    public Object[] callMethod(@Nonnull ILuaContext context, int method, @Nonnull Object[] arguments) throws LuaException, InterruptedException {
        return peripheral.callMethod(computer, context, method, arguments);
    }
}
