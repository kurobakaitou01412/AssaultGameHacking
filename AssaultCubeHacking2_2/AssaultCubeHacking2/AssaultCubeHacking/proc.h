#pragma once
#include "stdafx.h"
#include <vector>
#include <windows.h>


DWORD GetProcId(const wchar_t* procName);

uintptr_t GetModuleBaseAddress(DWORD procid, const wchar_t* moduleName);

uintptr_t FindDMAAddy(HANDLE hProc, uintptr_t ptr, std::vector<unsigned int> offsets);