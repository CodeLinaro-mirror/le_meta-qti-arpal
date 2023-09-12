inherit autotools pkgconfig

DESCRIPTION = "palserver"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/${LICENSE};md5=3771d4920bd6cdb8cbdf1e8344489ee0"

# src path
FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/ipc/SwBinders/pal_ipc_server"

S = "${WORKDIR}/vendor/qcom/opensource/pal/ipc/SwBinders/pal_ipc_server"
PR = "r0"

# dependency
DEPENDS = "libutils libcutils binder qal"


SOLIBS = ".so"

FILES_SOLIBSDEV = ""
