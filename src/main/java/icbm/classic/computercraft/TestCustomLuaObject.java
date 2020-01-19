package icbm.classic.computercraft;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.ILuaObject;
import dan200.computercraft.api.lua.LuaException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TestCustomLuaObject implements ILuaObject {
    @Nonnull
    @Override
    public String[] getMethodNames() {
        return new String[0];
    }

    @Nullable
    @Override
    public Object[] callMethod(@Nonnull ILuaContext iLuaContext, int i, @Nonnull Object[] objects) throws LuaException, InterruptedException {
        return new Object[0];
    }
}
