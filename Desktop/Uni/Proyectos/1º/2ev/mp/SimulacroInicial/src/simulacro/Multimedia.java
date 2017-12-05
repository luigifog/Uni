package simulacro;

import java.io.PrintStream;

public interface Multimedia {
	public abstract boolean isParado();
	public abstract void play(PrintStream out);
	public abstract void stop(PrintStream out);
}
