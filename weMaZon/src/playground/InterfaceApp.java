package playground;

/**
 * Created by oakinrele on Jul, 2020
 */
public class InterfaceApp {

    public static void main(String [] args)
    {
        MyControl myControl = new MyControl();

        IValidate validateControl = (IValidate)myControl;

        //ISerializable iSerializable = (ISerializable) myControl;

        boolean success = validateControl.Validate();
        System.out.println(String.format("The validation of %s was %s successful",myControl.data,(success ? "": "not")));
    }
}
         class FancyControl
          {
              public String data;
          }

                interface IValidate
                {
                    boolean Validate();
                }

                    class MyControl extends FancyControl implements IValidate
                    {
                        MyControl()
                        {
                             data = "my grid data";
                        }

                        public boolean Validate()
                        {
                            System.out.println(String.format("Validating.... %s",data));
                            return true;
                        }
                    }

                    interface ISerializable
                    {
                        boolean Save();
                    }
