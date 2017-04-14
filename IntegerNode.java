/**
 * 整数链表
 * @author Administrator
 *
 */
public class IntegerNode {
	
	int data ;
	
	IntegerNode next;
	
	public IntegerNode(int data) {
		this.data = data;
		this.next = null;
	}

	public static IntegerNode createLinkedListByArray(int []nums){
		IntegerNode head = new IntegerNode(nums[0]);
		for(int i = 1 ; i < nums.length ; i ++){
			head.appendToTail(nums[i]);
		}
		return head;
	}
	
	public void appendToTail(int d){
		IntegerNode p = this;
		IntegerNode node = new IntegerNode(d);
		while(p.next != null){
			p = p.next;
		}
		p.next = node;
	}
	
	public void appendToTail(IntegerNode node){
		IntegerNode p = this;		
		while(p.next != null){
			p = p.next;
		}
		p.next = node;
	}
	
	public IntegerNode deleteNode(int d){
		if(d == this.data)
			return this.next;
		IntegerNode p = this.next;
		IntegerNode pre = this;
		while(p != null){
			if(d == p.data){
				pre.next = p.next;
				break;
			}
			p = p.next;
			pre = pre.next;
		}
		return this;
	}
	
	public int length(){
		IntegerNode p = this;
		int count = 0 ; 
		while(p != null){
			count ++;
			p = p.next;
		}
		return count;
	}
	
	/**
	 * 链表反转，思想是 头插法
	 * @return
	 */
	public IntegerNode reverse(){
		if(this == null || this.length() == 1)
			return this;
		IntegerNode p1 = this;
		IntegerNode p2 = this.next;
		IntegerNode reverse = null;
		while(p2 != null){
			p1.next = reverse;
			reverse = p1;		
			
			p1 = p2; 
			p2 = p2.next;		
		}
		p1.next = reverse;
		reverse = p1;
		return reverse;
	}
	
	/**
	 * 递归反转法
	 * @return
	 */
	public IntegerNode reverseRecurrence(IntegerNode head){
		if(head == null || head.next == null)
			return head;
		IntegerNode pre = reverseRecurrence(head.next);
		head.next.next = head;
		head.next = null;
		return pre;
	}
	
	public void printNodesInfo(){
		IntegerNode p = this;
		int count = 0;
		while(p != null){
			System.out.print(p.data + " ");
			p = p.next;
			if(count > 100)
				break;
			count ++;
		}
		System.out.println();
	}
}
