SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ba0f09d3c58fdce7d7562a473132c918"

inherit cmake ptest systemd

SRC_URI = "\
  git://github.com/B-Michelsen/example-ptest.git;branch=master \
  file://run-ptest \
"

SRCREV = "7b8b3ba5b73dc88e4f47506126ba22a4121ab897"

S = "${WORKDIR}/git"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "example-ptest.service"

FILES_${PN} += "${systemd_system_unitdir}"

do_install_ptest() {
  install ${S}/component-test/*.py ${D}${PTEST_PATH}
}

RDEPENDS_${PN}-ptest = "\
  python3 \
  python3-pytest \
"

