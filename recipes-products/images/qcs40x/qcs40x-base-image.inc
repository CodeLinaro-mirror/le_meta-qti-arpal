# Rootfs creation.

IMAGE_INSTALL += "init-audio"

# Following packages support only 32-bit compilation.
# When 32-bit multilib is enabled, compile them with lib32- prefix.

AUDIOMODULE_FLAG = "${@bb.utils.contains('DISTRO_FEATURES', 'audio-dlkm', 'True', 'False', d)}"
IMAGE_INSTALL += "${@base_conditional('AUDIOMODULE_FLAG', 'True', bb.utils.contains('MULTILIB_VARIANTS', 'lib32', 'lib32-audiodlkm', 'audiodlkm', d), '', d)}"

#64 bit libs
IMAGE_INSTALL += "audiohal"
IMAGE_INSTALL += "tinyalsa"
IMAGE_INSTALL += "tinycompress"
IMAGE_INSTALL += "encoders"
IMAGE_INSTALL += "gpr"
IMAGE_INSTALL += "gsl"
IMAGE_INSTALL += "acdb"
IMAGE_INSTALL += "osal"
IMAGE_INSTALL += "gecko"
IMAGE_INSTALL += "qal"
IMAGE_INSTALL += "qahw"
