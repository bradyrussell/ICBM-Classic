package icbm.classic.computercraft;

import dan200.computercraft.api.filesystem.IMount;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMount implements IMount {
    @Override
    public boolean exists(@Nonnull String s) throws IOException {
        return false;
    }

    @Override
    public boolean isDirectory(@Nonnull String s) throws IOException {
        return false;
    }

    @Override
    public void list(@Nonnull String s, @Nonnull List<String> list) throws IOException {

    }

    @Override
    public long getSize(@Nonnull String s) throws IOException {
        return 0;
    }

    @Nonnull
    @Override
    public InputStream openForRead(@Nonnull String s) throws IOException {
        return null;
    }
}
