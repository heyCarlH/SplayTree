package SPLT_A4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class SplayTreeTests {

	@Test
	public void treeEqualsValidation() {
		BST_Node expected = new BST_Node("a"), tree = new BST_Node("a");
		tree.left = new BST_Node("b", null, null, tree);
		tree.right = new BST_Node("c", null, null, tree);
		tree.left.left = new BST_Node("d", null, null, tree.left);
		tree.left.right = new BST_Node("e", null, null, tree.left);
		tree.right.left = new BST_Node("f", null, null, tree.right);
		tree.right.right = new BST_Node("g", null, null, tree.right);

		expected.left = new BST_Node("b", null, null, expected);
		expected.right = new BST_Node("c", null, null, expected);
		expected.left.left = new BST_Node("d", null, null, expected.left);
		expected.left.right = new BST_Node("e", null, null, expected.left);
		expected.right.left = new BST_Node("f", null, null, expected.right);
		expected.right.right = new BST_Node("g", null, null, expected.right);
		assertTrue("Should pass if the `treeEquals` method works", this.treeEquals(tree, expected));

		expected.right.right = new BST_Node("h", null, null, expected.right);
		assertFalse("Should pass if the `treeEquals` method works", this.treeEquals(tree, expected));
	}

	@Test
	public void testFindMin() {
		try {
			SPLT tree = new SPLT();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("aa", null, null, null);
			BST_Node bb, ff, cc, ee, zz, gg;
			expected.right = bb = new BST_Node("bb", null, null, expected);
			bb.right = ff = new BST_Node("ff", null, null, bb);
			ff.left = cc = new BST_Node("cc", null, null, ff);
			cc.right = ee = new BST_Node("ee", null, null, cc);
			ee.left = new BST_Node("dd", null, null, ee);
			ff.right = gg = new BST_Node("gg", null, null, ff);
			gg.right = zz = new BST_Node("zz", null, null, gg);
			zz.left = new BST_Node("ss", null, null, zz);

			assertEquals("findMin returns wrong node", "aa", tree.findMin());
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testFindMax() {
		try {
			SPLT tree = new SPLT();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("zz", null, null, null);
			BST_Node bb, ff, cc, gg, ee;
			expected.left = bb = new BST_Node("bb", null, null, expected);
			bb.left = new BST_Node("aa", null, null, bb);
			bb.right = gg = new BST_Node("gg", null, null, bb);
			gg.right = new BST_Node("ss", null, null, gg);
			gg.left = ff = new BST_Node("ff", null, null, gg);
			ff.left = cc = new BST_Node("cc", null, null, ff);
			cc.right = ee = new BST_Node("ee", null, null, cc);
			ee.left = new BST_Node("dd", null, null, ee);

			assertEquals("findMax returns wrong node", "zz", tree.findMax());
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testContainsTrue() {
		try {
			SPLT tree = new SPLT();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("cc");
			BST_Node aa, ff, ee, zz, gg;
			expected.left = aa = new BST_Node("aa", null, null, expected);
			aa.right = new BST_Node("bb", null, null, aa);
			expected.right = ff = new BST_Node("ff", null, null, expected);
			ff.left = ee = new BST_Node("ee", null, null, ff);
			ee.left = new BST_Node("dd", null, null, ee);
			ff.right = gg = new BST_Node("gg", null, null, ff);
			gg.right = zz = new BST_Node("zz", null, null, gg);
			zz.left = new BST_Node("ss", null, null, zz);

			assertTrue("contains returns false", tree.contains("cc"));
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testContainsFalse() {
		try {
			SPLT tree = new SPLT();

			tree.insert("gg");
			tree.insert("dd");
			tree.insert("ss");
			tree.insert("ee");
			tree.insert("cc");
			tree.insert("zz");
			tree.insert("gg");
			tree.insert("bb");
			tree.insert("ff");
			tree.insert("aa");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("bb", null, null, null);
			BST_Node ff, cc, ee, zz, gg;
			expected.left = new BST_Node("aa", null, null, expected);
			expected.right = ff = new BST_Node("ff", null, null, expected);
			ff.left = cc = new BST_Node("cc", null, null, ff);
			cc.right = ee = new BST_Node("ee", null, null, cc);
			ee.left = new BST_Node("dd", null, null, ee);
			ff.right = gg = new BST_Node("gg", null, null, ff);
			gg.right = zz = new BST_Node("zz", null, null, gg);
			zz.left = new BST_Node("ss", null, null, zz);

			assertFalse("contains returns true", tree.contains("ad"));
			assertTrue("tree not splayed correctly", this.treeEquals(tree.getRoot(), expected));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testEmptyTrue() {
		try {
			SPLT tree = new SPLT();

			assertTrue("empty returns false", tree.empty());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testEmptyFalse() {
		try {
			SPLT tree = new SPLT();

			tree.insert("h");

			assertFalse("empty returns true", tree.empty());
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightInsertOnly() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("f");
			BST_Node b, e, c, g;
			expected.left = b = new BST_Node("b", null, null, expected);
			b.left = new BST_Node("a", null, null, b);
			b.right = e = new BST_Node("e", null, null, b);
			e.left = c = new BST_Node("c", null, null, e);
			c.right = new BST_Node("d", null, null, c);
			expected.right = g = new BST_Node("g", null, null, expected);
			g.right = new BST_Node("s", null, null, g);

			assertEquals("height returned wrong height", 4, tree.height());
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveRoot() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("f");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("e");
			BST_Node b, c, g;
			expected.left = b = new BST_Node("b", null, null, expected);
			b.left = new BST_Node("a", null, null, b);
			b.right = c = new BST_Node("c", null, null, b);
			c.right = new BST_Node("d", null, null, c);
			expected.right = g = new BST_Node("g", null, null, expected);
			g.right = new BST_Node("s", null, null, g);

			assertEquals("height returned wrong height", 3, tree.height());
			assertTrue("tree not splayed correctly", this.treeEquals(tree.getRoot(), expected));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testHeightRemoveOne() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("g");

			BST_Node expected = new BST_Node("f");
			BST_Node b, e, c;
			expected.left = b = new BST_Node("b", null, null, expected);
			b.left = new BST_Node("a", null, null, b);
			b.right = e = new BST_Node("e", null, null, b);
			e.left = c = new BST_Node("c", null, null, e);
			c.right = new BST_Node("d", null, null, c);
			expected.right = new BST_Node("s", null, null, expected);

			assertEquals("height returned wrong height", 4, tree.height());
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
			this.printInOrderRec(tree.getRoot());
			System.out.println();
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSizeInsertOnly() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("f");
			BST_Node b, e, c, g;
			expected.left = b = new BST_Node("b", null, null, expected);
			b.left = new BST_Node("a", null, null, b);
			b.right = e = new BST_Node("e", null, null, b);
			e.left = c = new BST_Node("c", null, null, e);
			c.right = new BST_Node("d", null, null, c);
			expected.right = g = new BST_Node("g", null, null, expected);
			g.right = new BST_Node("s", null, null, g);

			assertEquals("size returned wrong size", 8, tree.size());
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSizeRemove() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("g");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("f");
			BST_Node b, e, c;
			expected.left = b = new BST_Node("b", null, null, expected);
			b.left = new BST_Node("a", null, null, b);
			b.right = e = new BST_Node("e", null, null, b);
			e.left = c = new BST_Node("c", null, null, e);
			c.right = new BST_Node("d", null, null, c);
			expected.right = new BST_Node("s", null, null, expected);

			assertEquals("size returned wrong size", 7, tree.size());
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testInsert() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("c");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("f");
			BST_Node b, d, g;
			expected.right = g = new BST_Node("g", null, null, expected);
			g.right = new BST_Node("s", null, null, g);
			expected.left = d = new BST_Node("d", null, null, expected);
			d.right = new BST_Node("e", null, null, d);
			d.left = b = new BST_Node("b", null, null, d);
			b.left = new BST_Node("a", null, null, b);
			b.right = new BST_Node("c", null, null, b);

			assertEquals("inserted wrong node into spot", "s", tree.getRoot().right.right.getData());
			assertEquals("inserted wrong node into spot", "g", tree.getRoot().right.getData());
			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveTwo() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.remove("e");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("d");
			BST_Node c, b, f, g;
			expected.left = c = new BST_Node("c", null, null, expected);
			c.left = b = new BST_Node("b", null, null, c);
			b.left = new BST_Node("a", null, null, b);
			expected.right = f = new BST_Node("f", null, null, expected);
			f.right = g = new BST_Node("g", null, null, f);
			g.right = new BST_Node("s", null, null, g);

			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testRemoveThree() {
		try {
			SPLT tree = new SPLT();

			tree.insert("a");
			tree.insert("d");
			tree.insert("s");
			tree.insert("e");
			tree.insert("c");
			tree.insert("g");
			tree.insert("b");
			tree.insert("f");
			tree.insert("w");
			tree.insert("z");
			tree.insert("y");
			tree.insert("u");
			tree.remove("b");

			this.printInOrderRec(tree.getRoot());
			System.out.println();

			BST_Node expected = new BST_Node("a");
			BST_Node u, f, e, c, s, w, y;
			expected.right = u = new BST_Node("u", null, null, expected);
			u.left = f = new BST_Node("f", null, null, u);
			f.left = e = new BST_Node("e", null, null, f);
			e.left = c = new BST_Node("c", null, null, e);
			c.right = new BST_Node("d", null, null, c);
			f.right = s = new BST_Node("s", null, null, f);
			s.left = new BST_Node("g", null, null, s);
			u.right = w = new BST_Node("w", null, null, u);
			w.right = y = new BST_Node("y", null, null, w);
			y.right = new BST_Node("z");

			assertTrue("tree not splayed correctly", tree.getRoot().getData().equals(expected.getData()));
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void sizeMedium() {
		SPLT tree = new SPLT();
		tree.insert("a");
		tree.insert("b");
		tree.remove("a");
		assertEquals("size not correct", 1, tree.size());
	}

	public boolean treeEquals(BST_Node a, BST_Node b) {
		if (a == null) {
			return b == null;
		}
		if (a.getHeight() != b.getHeight()) {
			return false;
		}
		if (a.par != null && b.par != null && !a.par.getData().equals(b.par.getData())) {
			return false;
		}
		if (!a.getData().equals(b.getData())) {
			return false;
		}
		boolean left, right;
		if (a.left == null) {
			left = b.left == null;
		} else {
			left = this.treeEquals(a.left, b.left);
		}
		if (a.right == null) {
			right = b.right == null;
		} else {
			right = this.treeEquals(a.right, b.right);
		}
		return left && right;
	}

	private void printInOrderRec(BST_Node currRoot) {
		if (currRoot == null) {
			return;
		}
		this.printInOrderRec(currRoot.left);
		System.out.print(currRoot.getData() + ", ");
		this.printInOrderRec(currRoot.right);
	}

	static final int MAX = 200;

	@Test
	public void testSPLT() {
		try {
			SPLT b = new SPLT();
			assertTrue("Constructor did not establish required semantics",
					b.empty() && b.size() == 0 && b.getRoot() == null);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testGetRootEasy() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Hello World!");
			assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testGetRootMedium() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert(s = "Other world (after)...");
			assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testGetRootMediumPlus() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert(s = "Before world...");
			assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testGetRootChallenge() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert("Other world (after)...");
			b.insert(s = "Before world...");
			assertTrue("getRoot returned wrong value", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testInsertEasy() {
		try {
			SPLT b = new SPLT();
			int size = b.size();
			b.insert("Hello World!");
			assertEquals("Legal first insert failed", size + 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testInsertMedium() {
		try {
			SPLT b = new SPLT();
			b.insert("Mario World!");
			int size = b.size();
			b.insert("Hello World!");
			assertEquals("Legal insert failed", size + 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testInsertMediumPlus() {
		try {
			SPLT b = new SPLT();
			b.insert("Super Mario World!");
			int size = b.size();
			b.insert("Super Mario World!");
			assertTrue("Illegal insert returned true", size + 1 != b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testInsertHard() {
		try {
			SPLT b = new SPLT();
			for (int i = 0; i < MAX; i++) {
				String next;
				while ((next = RandomNum.nextString()).equals("Hello World!")) {
				}
				b.insert(next);
			}
			int size = b.size();
			b.insert("Hello World!");
			assertEquals("Legal insert failed", size + 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveEasy() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert("Yoshi's World");
			b.insert(s = "a Mario's World");
			int size = b.size();
			b.remove(s);
			assertEquals("Removing root node failed", size - 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveMedium() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert(s = "Yoshi's World");
			b.insert("Mario's World");
			int size = b.size();
			b.remove(s);
			assertEquals("Removing non-root node", size - 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveHard() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert(s = "Yoshi's World");
			b.insert("Mario's World");
			b.insert("Zuigi's World");
			int size = b.size();
			b.remove(s);
			assertEquals("Removing node failed", size - 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveChallenge() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Hello World!");
			int size = b.size();
			b.remove(s);
			assertEquals("Removing root with no children failed", size - 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveChallengePlus() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Hello World!");
			b.insert("Yoshi's World");
			b.insert("a Mario's World");
			int size = b.size();
			b.remove(s);
			assertEquals("Removing node failed", size - 1, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveFalseEasy() {
		try {
			SPLT b = new SPLT();
			int size = b.size();
			b.remove("any string");
			assertEquals("Removing node in empty tree succeeded", size, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveFalseMedium() {
		try {
			SPLT b = new SPLT();
			b.insert("Hello World!");
			b.insert("Yoshi's World");
			b.insert("a Mario's World");
			int size = b.size();
			b.remove("any string");
			assertEquals("Removing nonexistent node in tree succeeded", size, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testRemoveFalseHard() {
		try {
			SPLT b = new SPLT();
			String s = RandomNum.nextString();
			for (int i = 0; i < MAX; i++) {
				String next;
				while ((next = RandomNum.nextString()).equals(s)) {
				}
				b.insert(next);
			}
			int size = b.size();
			b.remove(s);
			assertEquals("Removing nonexistent node in tree succeeded", size, b.size());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMinEasy() {
		try {
			SPLT b = new SPLT();
			assertTrue("Empty tree returned non-null min value", b.findMin() == null);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMinMedium() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Hello World!");
			assertTrue("Min incorrect", s.equals(b.findMin()));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMinHard() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Hello World!");
			b.insert("Yoshi's World!");
			b.insert("Mario's World!");
			assertTrue("Min incorrect", s.equals(b.findMin()));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMinChallenge() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert("Yoshi's World!");
			b.insert("Mario's World!");
			b.insert(s = "A Toad's World!");
			assertTrue("Min incorrect", s.equals(b.findMin()));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMaxEasy() {
		try {
			SPLT b = new SPLT();
			assertTrue("Empty tree returned non-null max value", b.findMax() == null);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMaxMedium() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Hello World!");
			assertTrue("Max incorrect", s.equals(b.findMax()));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMaxHard() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert(s = "Yoshi's World!");
			b.insert("Mario's World!");
			assertTrue("Max incorrect", s.equals(b.findMax()));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testFindMaxChallenge() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert("Yoshi's World!");
			b.insert("Mario's World!");
			b.insert("A Toad's World!");
			b.insert(s = "Zuigi's World!");
			assertTrue("Max incorrect", s.equals(b.findMax()));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testEmptyEasy() {
		try {
			SPLT b = new SPLT();
			assertTrue("Empty tree reports not empty", b.empty());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testEmptyMedium() {
		try {
			SPLT b = new SPLT();
			b.insert("Hello World!");
			assertTrue("Non-empty tree reports empty", !b.empty());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testEmptyHard() {
		try {
			SPLT b = new SPLT();
			b.insert("Hello World!");
			b.remove("Hello World!");
			assertTrue("Empty tree reports not empty", b.empty());
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testEmptyChallenge() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert(s = "Mario World!");
			b.remove("Hello World!");
			assertTrue("Non-empty tree reports empty", !b.empty());
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testEmptyChallengePlus() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert("Mario World!");
			b.remove("Hello World!");
			b.remove("Mario World!");
			b.insert(s = "It's a whole new world!");
			assertTrue("Non-empty tree reports empty", !b.empty());
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testContainsEasy() {
		try {
			SPLT b = new SPLT();
			assertTrue("Empty tree contains something", !b.contains("A String"));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testContainsMedium() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Hello World!");
			assertTrue("Non-empty tree doesn't contain its root", b.contains(s));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testContainsMediumPlus() {
		try {
			SPLT b = new SPLT();
			b.insert("Hello World!");
			assertTrue("Non-empty tree contains something other than its root", !b.contains("A String"));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testContainsHard() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert("Hello World!");
			b.insert("A whole new World!");
			b.insert("000000");
			b.insert(s = "Elmo's World!");
			b.insert("Mario World!");
			b.insert("Luigi's World!");
			b.insert("Yoshi's World!");
			assertTrue("Non-empty tree doesn't contain sub-element", b.contains(s));
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testContainsHardPlus() {
		try {
			SPLT b = new SPLT();
			b.insert("Hello World!");
			b.insert("A whole new World!");
			b.insert("000000");
			b.insert("Elmo's World!");
			b.insert("Mario World!");
			b.insert("Luigi's World!");
			b.insert("Yoshi's World!");
			assertTrue("Non-empty tree contain non-element", !b.contains("H3110 W0R1D"));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testSizeEasy() {
		try {
			SPLT b = new SPLT();
			assertTrue("New tree not empty", b.size() == 0);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testSizeMedium() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Mario World!");
			assertTrue("Tree with only root does not have one element", b.size() == 1);
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testSizeHard() {
		try {
			SPLT b = new SPLT();
			String s = null;
			for (int i = 0; i < MAX; i++) {
				b.insert(s = RandomNum.nextString());
			}
			assertTrue("Tree with " + MAX + " elements does not have " + MAX + " elements", b.size() == MAX);
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testSizeChallenge() {
		try {
			SPLT b = new SPLT();
			String[] s = new String[MAX];
			for (int i = 0; i < MAX; i++) {
				b.insert(s[i] = RandomNum.nextString());
			}
			for (int i = 0; i < MAX / 2; i++) {
				b.remove(s[i]);
			}
			assertTrue("Tree with " + MAX / 2 + " elements does not have " + MAX / 2 + " elements",
					b.size() == MAX / 2);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testSizeChallengePlus() {
		try {
			SPLT b = new SPLT();
			String[] s = new String[MAX];
			for (int i = 0; i < MAX; i++) {
				b.insert(s[i] = RandomNum.nextString());
			}
			for (String str : s) {
				b.remove(str);
			}
			assertTrue("Empty tree has elements", b.size() == 0);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testHeightEasy() {
		try {
			SPLT b = new SPLT();
			assertTrue("New tree has wrong height", b.height() == -1);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

	@Test
	public void testHeightMedium() {
		try {
			SPLT b = new SPLT();
			String s;
			b.insert(s = "Mario World!");
			assertTrue("Root-only tree has wrong height", b.height() == 0);
			assertTrue("Tree malformed", s.equals(b.getRoot().getData()));
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
		}
	}

}