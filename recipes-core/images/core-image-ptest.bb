DESCRIPTION = "A console-only image with more full-featured Linux system \
functionality installed."

IMAGE_FEATURES += "splash ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    example-ptest \
    ptest-runner \
    "

DISTRO_FEATURES_append = " ptest systemd"
EXTRA_IMAGE_FEATURES_append = " ptest-pkgs"
TEST_SUITES = "example-ptest"
INHERIT += "testimage" 
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"

inherit core-image
