/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.android.apps.forscience.whistlepunk.audiogen.voices;

import com.jsyn.ports.UnitInputPort;
import com.jsyn.ports.UnitOutputPort;
import com.softsynth.shared.time.TimeStamp;
/**************
** WARNING - this code automatically generated by Syntona.
** The real source is probably a Syntona patch.
** Do NOT edit this file unless you copy it to another directory and change the name.
** Otherwise it is likely to get clobbered the next time you
** export Java source code from Syntona.
**
** Syntona is available from: http://www.softsynth.com/syntona/
*/
public class SimpleJsynUnitVoice extends SimpleJsynUnitVoiceBase
{
    // Declare units and ports.
    com.jsyn.unitgen.PassThrough frequencyPassThrough;
    public UnitInputPort frequency;
    com.jsyn.unitgen.PassThrough amplitudePassThrough;
    public UnitInputPort amplitude;
    com.jsyn.unitgen.PassThrough outputPassThrough;
    public UnitOutputPort output;
    com.jsyn.unitgen.LinearRamp freqRampLin;
    com.jsyn.unitgen.SineOscillator sineOsc;
    com.jsyn.unitgen.LinearRamp ampRampLin;
    com.jsyn.unitgen.PassThrough freqRampLinTimePassThrough;
    public UnitInputPort freqRampLinTime;
    com.jsyn.unitgen.PassThrough ampRampLinTimePassThrough;
    public UnitInputPort ampRampLinTime;

    // Declare inner classes for any child circuits.

    public SimpleJsynUnitVoice()
    {
        // Create unit generators.
        add( frequencyPassThrough = new com.jsyn.unitgen.PassThrough() );
        addPort( frequency = frequencyPassThrough.input, "frequency");
        add( amplitudePassThrough = new com.jsyn.unitgen.PassThrough() );
        addPort( amplitude = amplitudePassThrough.input, "amplitude");
        add( outputPassThrough = new com.jsyn.unitgen.PassThrough() );
        addPort( output = outputPassThrough.output, "output");
        add( freqRampLin = new com.jsyn.unitgen.LinearRamp());
        add(sineOsc = new com.jsyn.unitgen.SineOscillator() );
        add( ampRampLin = new com.jsyn.unitgen.LinearRamp());
        add(freqRampLinTimePassThrough = new com.jsyn.unitgen.PassThrough());
        addPort(freqRampLinTime = freqRampLinTimePassThrough.input, "freqRampLinTime");
        add(ampRampLinTimePassThrough = new com.jsyn.unitgen.PassThrough());
        addPort(ampRampLinTime = ampRampLinTimePassThrough.input, "ampRampLinTime");
        // Connect units and ports.
        frequencyPassThrough.output.connect(freqRampLin.input);
        amplitudePassThrough.output.connect(ampRampLin.input);
        freqRampLin.output.connect(sineOsc.frequency);
        sineOsc.output.connect(outputPassThrough.input);
        ampRampLin.output.connect(sineOsc.amplitude);
        freqRampLinTimePassThrough.output.connect(freqRampLin.time);
        ampRampLinTimePassThrough.output.connect(ampRampLin.time);
        // Setup
        frequency.setup(0.0, 440.0, 1000.0);
        amplitude.setup(0.0, 1.0, 1.0);
        freqRampLinTime.setup(0.0, 0.05, 1.0);
        ampRampLinTime.setup(0.0, 0.1, 1.0);
    }

    public void noteOn( double frequency, double amplitude, TimeStamp timeStamp )
    {
        this.frequency.set( frequency, timeStamp );
        this.amplitude.set( amplitude, timeStamp );
    }

    public void noteOff( TimeStamp timeStamp )
    {
    }
    
    public UnitOutputPort getOutput()
    {
        return output;
    }
}
