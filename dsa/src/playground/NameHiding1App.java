package playground;

/**
 * Created by oakinrele on Jul, 2020
 */
public class NameHiding1App {

    public static void main(String [] args)
    {
        EditBox editBox = new EditBox();
        System.out.println("Calling EditBox.Bind()...");
        editBox.Bind();
        System.out.println();
        IDataBound iDataBound = (IDataBound) editBox;
        System.out.println("Calling (IDataBound)EditBox.Bind()...");
        iDataBound.Bind();
    }


}


interface IDataBound
{
    void Bind();
}

class EditBox implements IDataBound
{
    public void Bind()
    {
        System.out.println("Binding to data store...");
    }
}
