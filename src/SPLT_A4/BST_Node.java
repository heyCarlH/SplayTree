package SPLT_A4;

public class BST_Node {
	String data;
	BST_Node left;
	BST_Node right;
	BST_Node par; // parent...not necessarily required, but can be useful in
					// splay tree
	boolean justMade; // could be helpful if you change some of the return types
						// on your BST_Node insert.

	// I personally use it to indicate to my SPLT insert whether or not we
	// increment size.

	BST_Node(String data) {
		this.data = data;
		this.justMade = true;
		// justMade is instantiated to true whenever a new
		// node is created.
	}

	BST_Node(String data, BST_Node left, BST_Node right, BST_Node par) {
		// feel free to modify this constructor to suit your needs
		this.data = data;
		this.left = left;
		this.right = right;
		this.par = par;
		this.justMade = true;
	}

	// --- used for testing ----------------------------------------------
	//
	// leave these 3 methods in, as is (meaning also make sure they do in fact
	// return data,left,right respectively)

	public String getData() {
		return this.data;
	}

	public BST_Node getLeft() {
		return this.left;
	}

	public BST_Node getRight() {
		return this.right;
	}

	// --- end used for testing -------------------------------------------

	// --- Some example methods that could be helpful
	// ------------------------------------------
	//
	// add the meat of correct implementation logic to them if you wish

	// you MAY change the signatures if you wish...names too (we will not grade
	// on delegation for this assignment)
	// make them take more or different parameters
	// have them return different types
	//
	// you may use recursive or iterative implementations

	public BST_Node containsNode(String s) {
		if (this.data.equals(s)) {
			this.splay(this);
			return (this);
		}
		if (this.data.compareTo(s) < 0) {
			if (this.right == null) {
				this.splay(this);
				return (this);
			}
			return this.right.containsNode(s);
		}
		if (this.data.compareTo(s) > 0) {
			// If s should be on the left of the current node
			if (this.left == null) {
				// but instead the left child of the current
				// node is null
				this.splay(this);
				// then splay the current node
				return (this);
				// and return the current node
			}
			return this.left.containsNode(s);
			// else, recursively find s
		}
		return null;
		// This should not occur
	}
	// note: I personally find it easiest to make this return a Node,(that
	// being the node splayed to root), you are however free to do what you
	// wish.

	public BST_Node insertNode(String s) {
		if (this.data.compareTo(s) > 0) {
			if (this.left == null) {
				this.left = new BST_Node(s, null, null, this);
				// New node made; it is easier to specify its children
				// here by using the more complicated constructor
				// justMade indicator becomes true
				BST_Node insertedNode = this.left;
				// Because we need to splay the inserted node later,
				// we need to save it to a temp variable so that we
				// could return it later
				this.splay(this.left);
				return insertedNode;
			}
			return this.left.insertNode(s);
		}
		if (this.data.compareTo(s) < 0) {
			if (this.right == null) {
				this.right = new BST_Node(s, null, null, this);
				BST_Node insertedNode = this.right;
				this.splay(this.right);
				return insertedNode;
			}
			return this.right.insertNode(s);
		}
		this.splay(this);
		// If we have already have the element, then just spaly that element
		// and return it, and because there is no new node created,
		// the justMade indicator will remain false
		return this;
	} // Really same logic as above note

	public BST_Node findMin() {
		if (this.left != null) {
			return this.left.findMin();
		}
		this.splay(this);
		return this;
	}

	public BST_Node findMax() {
		if (this.right != null) {
			return this.right.findMax();
		}
		this.splay(this);
		return this;
	}

	public int getHeight() {
		int l = 0;
		int r = 0;
		if (this.left != null) {
			l += this.left.getHeight() + 1;
		}
		if (this.right != null) {
			r += this.right.getHeight() + 1;
		}
		return Integer.max(l, r);
	}

	private void leftChildBecomesParent(BST_Node aNode, BST_Node parentOfaNode) {
		// parentOfaNode is the parent node of aNode
		if ((aNode == null) || (parentOfaNode == null) || (aNode.par != parentOfaNode)
				|| (parentOfaNode.left != aNode)) {
			return;
		}
		if (parentOfaNode.par != null) {
			if (parentOfaNode == parentOfaNode.par.left) {
				parentOfaNode.par.left = aNode;
			} else {
				parentOfaNode.par.right = aNode;
			}
		}
		if (aNode.right != null) {
			aNode.right.par = parentOfaNode;
		}
		aNode.par = parentOfaNode.par;
		parentOfaNode.par = aNode;
		parentOfaNode.left = aNode.right;
		aNode.right = parentOfaNode;
	}

	private void rightChildBecomesParent(BST_Node aNode, BST_Node parentOfaNode) {
		if ((aNode == null) || (parentOfaNode == null) || (aNode.par != parentOfaNode)
				|| (parentOfaNode.right != aNode)) {
			return;
		}
		if (parentOfaNode.par != null) {
			if (parentOfaNode == parentOfaNode.par.left) {
				parentOfaNode.par.left = aNode;
			} else {
				parentOfaNode.par.right = aNode;
			}
		}
		if (aNode.left != null) {
			aNode.left.par = parentOfaNode;
		}
		aNode.par = parentOfaNode.par;
		parentOfaNode.par = aNode;
		parentOfaNode.right = aNode.left;
		aNode.left = parentOfaNode;
	}

	private void splay(BST_Node toSplay) {
		while (toSplay.par != null) {
			BST_Node parent = toSplay.par;
			BST_Node grandparent = parent.par;
			if (grandparent == null) {
				if (toSplay == parent.left) {
					this.leftChildBecomesParent(toSplay, parent);
				} else {
					this.rightChildBecomesParent(toSplay, parent);
				}
			} else {
				if (toSplay == parent.left) {
					if (parent == grandparent.left) {
						this.leftChildBecomesParent(toSplay, parent);
						this.leftChildBecomesParent(toSplay, grandparent);
					} else {
						this.leftChildBecomesParent(toSplay, parent);
						this.rightChildBecomesParent(toSplay, grandparent);
					}
				} else {
					if (parent == grandparent.left) {
						this.rightChildBecomesParent(toSplay, parent);
						this.leftChildBecomesParent(toSplay, grandparent);
					} else {
						this.rightChildBecomesParent(toSplay, parent);
						this.rightChildBecomesParent(toSplay, grandparent);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Data: " + this.data + ", Left: " + ((this.left != null) ? this.left.data : "null") + ",Right: "
				+ ((this.right != null) ? this.right.data : "null");
	}

	// --- end example methods --------------------------------------

	// --------------------------------------------------------------------
	// you may add any other methods you want to get the job done
	// --------------------------------------------------------------------

}
