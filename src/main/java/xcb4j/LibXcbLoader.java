package xcb4j;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class LibXcbLoader {

	private static final String LIBXCB_BASE_NAME = "libxcb4j";

	public static void load() {
		final String jreArch = System.getProperty("os.arch");
		final String libName = LibXcbLoader.LIBXCB_BASE_NAME + "_" + jreArch + ".so";

		final URL libUrl = LibXcbLoader.class.getClassLoader().getResource(libName);
		try {
			final String path = new File(new URI(libUrl.toString())).getAbsolutePath();

			System.load(path);
		} catch (final URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}