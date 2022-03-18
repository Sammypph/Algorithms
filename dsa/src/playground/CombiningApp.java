package playground;

/**
 * Created by oakinrele on Jul, 2020
 */



/*
Interfaces allow the development of classes that can share features but that are not part of the same class hierarchy
*/


public class CombiningApp {
    public static void main(String [] args)
    {
       TreeView treeView = new TreeView();
       treeView.Combine();
       treeView.Drag();
       treeView.Drop();
       treeView.Serialize();
    }
}


class Control
{
}

interface IDragDrop
{
    void Drag();
    void Drop();
}

interface ISortable
{
    void Serialize();
}


//You can aggregate semantically related interfaces into a single interface and also add additional methods
interface ICombo extends IDragDrop,ISortable
{
    void Combine();
}


class TreeView extends Control implements ICombo
{
    public void Drag()
    {
        System.out.println("TreeView.Drag called");
    }

    public void Drop()
    {
        System.out.println("TreeView.Drop called");
    }

    public void Serialize()
    {
        System.out.println("TreeView.Serialize called");
    }

    public void Combine()
    {
        System.out.println("TreeView.Combine called");
    }
}
