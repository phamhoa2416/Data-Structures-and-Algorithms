#include <iostream>

class Node
{
private:
    int data;
    Node *next;

public:
    Node()
    {
        data = 0;
        this->next = nullptr;
    }

    Node(int data)
    {
        this->data = data;
        this->next = nullptr;
    }

    int getData() const
    {
        return data;
    }

    void setData(int data)
    {
        this->data = data;
    }

    void insertEnd(Node *&head, int data)
    {
        Node *newNode = new Node(data);

        if (head == nullptr)
        {
            head = newNode;
        }

        Node *current = head;
        while (current->next != nullptr)
        {
            current = current->next;
        }
        current->next = newNode;
    }

    void display(Node *head)
    {
        Node *current = head;
        while (current != nullptr)
        {
            std::cout << current->data << " ";
            current = current->next;
        }
    }
};

int main()
{
    Node *head = nullptr;
    Node node;
    node.insertEnd(head, 1);
    node.insertEnd(head, 2);
    node.insertEnd(head, 3);
    node.insertEnd(head, 4);
    node.insertEnd(head, 5);

    node.display(head);
}
