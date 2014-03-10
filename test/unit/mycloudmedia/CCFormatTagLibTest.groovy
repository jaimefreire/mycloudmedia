package mycloudmedia

import grails.test.mixin.TestFor
import org.junit.Test

@TestFor(CCFormatTagLib)
class CCFormatTagLibTest {

    @Test
    void correctlyApplyCCMask() {
        String result = applyTemplate('<g:formatCC number="${number}"/>', [number: new String("371449635398431")]).trim()

        assert result.equals('XXXX XXXX XXXX 8431')
    }
}
