Tested with `javac *.java && java Packer < ptest.txt > packer.txt && java Unpacker < packer.txt > unpack.txt && java Decoder ../dict.txt  < unpack.txt`
This assumes that Java8 is used
Packer has one arg for the dictionaries location, will crash if not found