import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A utility class for finding all text files in a directory using lambda
 * functions and streams.
 *
 * @author CS 212 Software Development
 * @author University of San Francisco
 * @version Fall 2019
 */
public class TextFileFinder {

	/**
	 * A lambda function that returns true if the path is a file that ends in a .txt or .text extension
	 * (case-insensitive). Useful for {@link Files#walk(Path, FileVisitOption...)}.
	 *
	 * @see Files#isRegularFile(Path, java.nio.file.LinkOption...)
	 * @see Path#getFileName()
	 * @see Files#walk(Path, FileVisitOption...)
	 */
	// TODO FILL IN USING LAMBDA FUNCTION
	public static final Predicate<Path> IS_TEXT = null;

	/**
	 * A lambda function that returns true if the path is a file that ends in a .txt or .text extension
	 * (case-insensitive). Useful for {@link Files#find(Path, int, BiPredicate, FileVisitOption...)}.
	 *
	 * @see Files#find(Path, int, BiPredicate, FileVisitOption...)
	 */
	// DO NOT MODIFY; THIS IS PROVIDED FOR YOU
	// (Hint: This is only useful if you decide to use Files.find(...) instead of Files.walk(...)
	public static final BiPredicate<Path, BasicFileAttributes> IS_TEXT_ATTR = (path, attr) -> IS_TEXT.test(path);

	/**
	 * Returns a stream of text files, following any symbolic links encountered.
	 *
	 * @param start the initial path to start with
	 * @return a stream of text files
	 *
	 * @throws IOException
	 *
	 * @see #IS_TEXT
	 * @see #IS_TEXT_ATTR
	 *
	 * @see FileVisitOption#FOLLOW_LINKS
	 * @see Files#walk(Path, FileVisitOption...)
	 * @see Files#find(Path, int, java.util.function.BiPredicate, FileVisitOption...)
	 *
	 * @see Integer#MAX_VALUE
	 */
	public static Stream<Path> find(Path start) throws IOException {
		// TODO YOU MUST USE STREAMS HERE
		throw new UnsupportedOperationException("Not yet implemented.");
	}

	/**
	 * Returns a list of text files.
	 *
	 * @param start the initial path to search
	 * @return list of text files
	 * @throws IOException
	 *
	 * @see #find(Path)
	 */
	public static List<Path> list(Path start) throws IOException {
		// THIS METHOD IS PROVIDED FOR YOU DO NOT MODIFY
		return find(start).collect(Collectors.toList());
	}

	/**
	 * Demonstrates usage of this class.
	 *
	 * @param args unused
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Modify or remove as needed to debug code.

		String format = "%-25s: %b%n";

		Path validText1 = Path.of("text", "simple", "hello.txt");
		System.out.printf(format, validText1, IS_TEXT.test(validText1));

		Path validText2 = Path.of("text", "simple", "words.tExT");
		System.out.printf(format, validText2, IS_TEXT.test(validText2));

		Path invalidText1 = Path.of("text", "simple", "no_extension");
		System.out.printf(format, invalidText1, IS_TEXT.test(invalidText1));

		Path invalidText2 = Path.of("text", "simple", "dir.txt");
		System.out.printf(format, invalidText2, IS_TEXT.test(invalidText2));

		Path simple = Path.of("text", "simple");
		System.out.println();
		System.out.println(list(simple));
	}
}
