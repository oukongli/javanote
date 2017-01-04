package com.shdev.note.innerClass;

/**
 * Created by ou_ko on 2017/1/4.
 */
public class Outer {
    private int x = 100;

    class Inner {
        private int y = 1;

        public int innerAdd() {
            return x + y;
        }
    }

    interface AnnoInner {
        int addXYZ();
    }

    class Outer_1 {
        public AnnoInner getAnnoInner(final int x) {
            final int y = 2;
            return new AnnoInner() {
                @Override
                public int addXYZ() {
                    int z = 3;
                    return x + y + z;
                }
            };
        }
    }

    class Outer_2 {
        public void function(final int x) {
            final int y = 2;
            class MethodInner {
                public int add() {
                    int z = 3;
                    return x + y;
                }
            }
        }
    }

    class Outer_3 {
        private int x = 0;

        {
            final int y = 2;
            class MethodInner {
                public int add() {
                    int z = 3;
                    return x + y;
                }
            }
        }
    }
}
