inherit autotools pkgconfig

DESCRIPTION = "palclient"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta-qti-bsp/files/common-licenses/${LICENSE};md5=3771d4920bd6cdb8cbdf1e8344489ee0"

FILESPATH =+ "${WORKSPACE}/:"
SRC_URI  = "file://vendor/qcom/opensource/pal/ipc/SwBinders/pal_ipc_client"

S = "${WORKDIR}/vendor/qcom/opensource/pal/ipc/SwBinders/pal_ipc_client"
PR = "r0"

DEPENDS = "libutils libcutils binder palserver qal-headers"


SOLIBS = ".so"

FILES_SOLIBSDEV = ""
