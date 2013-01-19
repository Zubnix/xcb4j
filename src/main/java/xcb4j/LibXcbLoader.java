package xcb4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LibXcbLoader {

	private static final String LIBXCB_BASE_NAME = "libxcb4j";

	public static void load() {
		final String jreArch = System.getProperty("os.arch");
		final String libName = LibXcbLoader.LIBXCB_BASE_NAME + "_" + jreArch + ".so";

		InputStream in = LibXcbLoader.class.getClassLoader().getResourceAsStream(libName);
		byte[] buffer = new byte[4096];
		int read = -1;
		File temp = new File(	new File(System.getProperty("java.io.tmpdir")),
								libName);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(temp);
			while ((read = in.read(buffer)) != -1) {
				fos.write(	buffer,
							0,
							read);
			}
			fos.close();
			in.close();

			System.load(temp.getAbsolutePath());
		} catch (FileNotFoundException e) {
			throw new Error(e);
		} catch (IOException e) {
			throw new Error(e);
		}
	}
}