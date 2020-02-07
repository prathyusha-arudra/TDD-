import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class test {

    @Mock
    FileInput file;
    ArmstrongNumber a;
    ArmstrongNumber a1;

    @Spy
    FileInput file1;

    @Before
    public void setUp() throws Exception{
        file= mock(FileInput.class);
        a=new ArmstrongNumber();
        a.setReadObject(file);

        a1=new ArmstrongNumber();
        file1=spy(new FileInput());
        a1.setReadObject(file);

        System.out.println("This is executed before ");
    }

    @Test
    public void changeOnAccess() throws Exception{
        file= mock(FileInput.class);
        a=new ArmstrongNumber();
        a.setReadObject(file);
        when(file.FileInput(anyString())).thenReturn(153);
        boolean answer= ArmstrongNumber.checkArmstrongNumber();
        verify(file).FileInput(anyString());
    }

    @Test
    public void checkArmstrongNumber() throws Exception{
        file= mock(FileInput.class);
        a=new ArmstrongNumber();
        a.setReadObject(file);
        when(file.FileInput(anyString())).thenReturn(153);
        boolean answer= ArmstrongNumber.checkArmstrongNumber();
        assertTrue(answer);
    }

    @Test
    public void invalidArmstrong() throws Exception{
        a1=new ArmstrongNumber();
        file1=spy(new FileInput());
        a1.setReadObject(file1);
        doReturn(10).when(file1).FileInput(anyString());
        boolean answer=ArmstrongNumber.checkArmstrongNumber();
        assertFalse(answer);
    }
}
