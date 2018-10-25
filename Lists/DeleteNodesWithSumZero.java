/*
  
  * Delete the nodes of linked list, whose sum is zero

  	soln : If the node list considered to be continous, iterate till sum becomes zero
  			and point the start point to the next node.

  		   If the node list isn't continous, store the nodes in stack or list and deleteing the nodes
  		   which makes sum equal to zero.		 
 */

// Considering, sum should be contigious. Using approch 1.

public class DeleteNodesWithSumZero extends LinkedList
{
	public static void main(String[] args)
	{
			LinkedList l = new DeleteNodesWithSumZero();

			l.add(-6);
			l.add(6);
			l.add(10);
			l.add(-30);
			l.add(15);
			l.add(15);
			l.add(12);

			l.display();
			((DeleteNodesWithSumZero) l).DeleteNodes();
			l.display();
	}

	public void DeleteNodes()
	{
		head = DeleteNodes(head);
	}

	private Node DeleteNodes(Node head)
	{
		Node curr = head;
		Node end;

		while(curr != null)
		{
			end = curr.next;
			int sum = curr.data;
			boolean flag = false;

			while(end != null)
			{
				sum += end.data;

				if(sum == 0)
				{
					if(curr.equals(head))
					{
						curr.next = end.next;
						curr = curr.next;
						head = curr;
						flag = true;
						break; 
					}
					else
					{
						curr.next = end.next;
						curr.data = curr.next.data;
						curr.next = curr.next.next;
						flag = true;
						break;
					}
				}
				end = end.next;
			}

			if(!flag)
				curr = curr.next;
		}

		return head;
	}
}