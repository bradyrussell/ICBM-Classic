package icbm.classic.computercraft;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;

public class CCUtil {
    public static LuaObjectPeripheralWrap[] wrapPeripheral(IPeripheral peripheral, IComputerAccess computer){
        return new LuaObjectPeripheralWrap[]{new LuaObjectPeripheralWrap(peripheral,computer)};
    }
}
