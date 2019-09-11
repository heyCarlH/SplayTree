package SPLT_A4;

public class SPLT implements SPLT_Interface {
	private BST_Node root;
	private int size;

	public SPLT() {
		this.size = 0;
	}

	@Override
	public BST_Node getRoot() { // please keep this in here! I need your root
								// node to test your tree!
		return this.root;
	}

	@Override
	public void insert(String s) {
		// Here we can ignore the fact that there is duplicate
		// because the delegated method will do the check for us
		if (this.empty()) {
			this.root = new BST_Node(s);
		} else {
			this.root = this.root.insertNode(s);
		}
		// If a new node is inserted, reset justMade to false;
		// If instead the tree already contains the node, then we do not add 1
		// to size
		if (this.root.justMade == true) {
			this.root.justMade = false;
			this.size++;
		}
	}

	@Override
	public void remove(String s) {
		// According to the hint, there is no need to
		// use delegation here because we are always
		// removing the root!
		if (this.empty() || this.contains(s) == false) {
			return;// Do nothing
		}
		// If the root's right child is not null, store the left child of the
		// current root into a temp variable
		if (this.root.left != null) {
			BST_Node originalRootRightChild = this.root.right;
			// If the current root's left, then make the minimum of right child
			// be the root; make the left child of the new root
			// the original root's left child
			// else, make the right child
			// itself be the root instead
			if (originalRootRightChild != null) {
				this.root = this.root.left.findMax();
				this.root.right = originalRootRightChild;
			} else {
				this.root = this.root.left;
			}
			// If the new root's left child is not null then make the new root's
			// left child's parent to be this new root.
			// If the right child is null then make the root to be the left
			// child (in order to remove root)
			if (this.root.right != null) {
				this.root.right.par = this.root;
			}
		} else {
			this.root = this.root.right;
		}
		// After the previous delete operation, we need to make the new root
		// really root by cutting away its parent
		if (this.root != null) {
			this.root.par = null;
		}
		this.size--;

	}

	@Override
	public String findMin() {
		if (this.empty()) {
			return null;
		} else {
			this.root = this.root.findMin();
			return this.root.data;
		}
	}

	@Override
	public String findMax() {
		if (this.empty()) {
			return null;
		} else {
			this.root = this.root.findMax();
			return this.root.data;
		}
	}

	@Override
	public boolean empty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		if (this.empty()) {
			return false;
		}
		this.root = this.root.containsNode(s);
		if (this.root.data.equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int height() {
		if (this.empty()) {
			return -1;
		} else {
			return this.root.getHeight();
		}
	}

}