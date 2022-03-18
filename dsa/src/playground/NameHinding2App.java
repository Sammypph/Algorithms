package playground;

/**
 * Created by oakinrele on Jul, 2020
 */

//Name Hiding: A method to prevent the implemented members of interfaces from becoming public members of the class
public class NameHinding2App {
    public static void main(String [] args)
    {
//        EditBox1 editBox = new EditBox1();
//        System.out.println("Calling EditBox.Bind()...");
//        //editBox.Bind();
//        System.out.println();
//        IDataBound iDataBound = (IDataBound) editBox;
//        System.out.println("Calling (IDataBound)EditBox.Bind()...");
//        iDataBound.Bind();
    }
}



interface IDataBound1
{
    void Bind();
}


//N.B: Only works in C#
// This prevents the member from being visible outside of the current class

//class EditBox1 implements IDataBound1
//{
//     void IDataBound1.Bind()
//    {
//        System.out.println("Binding to data store...");
//    }
//}
